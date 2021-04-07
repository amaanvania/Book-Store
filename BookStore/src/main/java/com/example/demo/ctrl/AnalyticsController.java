package com.example.demo.ctrl;


import com.example.demo.beans.AnnomizedReport;
import com.example.demo.beans.Book;
import com.example.demo.beans.ProductOrder;
import com.example.demo.beans.ProductOrderItem;
import com.example.demo.dao.BookDAO;
import com.example.demo.dao.ProductOrderDAO;
import com.example.demo.dao.ProductOrderItemDAO;
import com.example.demo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {


    @Autowired
    ProductOrderItemDAO pd;

    @Autowired
    BookDAO bd;

    @Autowired
    UserDAO ud;

    @GetMapping("month/{month}")
    public List<ProductOrderItem> generateMonthlyReport(@RequestParam int month) throws SQLException {
        return pd.getSortedBooksByMonth(month);
    }

    @GetMapping("/top10")
    public List<ProductOrderItem> analytics(){

        return pd.getTopTenSoldBooks();
    }

    @GetMapping("user/report")
    public List<AnnomizedReport> anonymizedReport(){
        return ud.getUserDetails();
    }
}
