package com.example.demo.mapper;

import com.example.demo.beans.AnnomizedReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/*
    Mapper for AnnomizedReport objects
    used to map result sets to
    address AnnomizedReport
*/
public class AnnomizedReportMapper implements RowMapper<AnnomizedReport> {

    @Override
    public AnnomizedReport mapRow(ResultSet rs, int rowNum) throws SQLException {
        AnnomizedReport ar = new AnnomizedReport();
        ar.setTotal_amount(rs.getDouble(2));
        ar.setZip_code(rs.getString(3));
        return ar;
    }
}
