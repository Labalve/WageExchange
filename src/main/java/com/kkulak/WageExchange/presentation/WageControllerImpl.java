package com.kkulak.WageExchange.presentation;
import com.kkulak.WageExchange.domain.MonthlyNetService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class WageControllerImpl {

    @Autowired
    MonthlyNetService monthlyNetService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity get(@RequestParam("value") BigDecimal value, @RequestParam("country") String countryName){
        throw new UnsupportedOperationException();
    }
    
}
