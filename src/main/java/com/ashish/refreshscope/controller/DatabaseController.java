package com.ashish.refreshscope.controller;

import com.ashish.refreshscope.dto.DataSourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@RestController
@RequestMapping("/database")
public class DatabaseController {
    @Autowired
    private DataSourceDto dataSourceDto;
    @Autowired
    private RefreshScope refreshScope;

    @PostMapping("/setting")
    public ResponseEntity<String> setting(@RequestBody DataSourceDto request) {
        Optional<DataSourceDto> requestData = Optional.ofNullable(request);
        Function<DataSourceDto, ResponseEntity<String>> consumer = r-> {
            Optional.ofNullable(r.getPassword()).ifPresent(dataSourceDto::setPassword);
            Optional.ofNullable(r.getUsername()).ifPresent(dataSourceDto::setUsername);
            refreshScope.refresh(DataSource.class);
            return new ResponseEntity<>(HttpStatus.OK);
        };
        Supplier<ResponseEntity<String>> badRequest = ()-> new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return requestData.map(consumer).orElseGet(badRequest);
    }
}
