package domain;

import java.math.BigDecimal;

public interface MonthlyNetService {
 
    Wage getMonthlyNet(BigDecimal value, String country);
    
}
