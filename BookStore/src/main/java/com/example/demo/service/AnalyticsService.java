package com.example.demo.service;


import com.example.demo.beans.MonthBookSale;
import com.example.demo.dao.ProductOrderItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.Month;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnalyticsService {

    @Autowired
    ProductOrderItemDAO pd;


    @Transactional
    public Map<String, List<MonthBookSale>> getMonthlyBookSales(int year) throws SQLException {
        Map<String, List<MonthBookSale>> result = new LinkedHashMap<>();
        for(int i = 1; i <= 12; i++){
            String month = Month.of(i).toString();
            List<MonthBookSale> curr = pd.getSortedBooksByMonth(i,year);
            result.put(month,curr);
        }

        return result;
    }


}
