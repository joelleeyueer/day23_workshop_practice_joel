package nus.day23_workshop_practice.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nus.day23_workshop_practice.models.Order;

@Repository
public class OrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    //constant
    private static final String FIND_BY_ORDERID_SQL = "SELECT o.id AS order_id, o.order_date, o.customer_id," +
       " (SUM(od.quantity * od.unit_price * (1 - od.discount))) AS total_price," +
       " (SUM(od.quantity * p.standard_cost)) AS cost_price, " +
       " (SUM(od.quantity * od.unit_price * (1 - od.discount)) - SUM(od.quantity * p.standard_cost)) AS discount " +
        " FROM orders o " +
        " JOIN order_details od ON o.id = od.order_id " +
        " JOIN products p ON od.product_id = p.id " +
        " WHERE o.id = ? " +
        " GROUP BY o.id, o.order_date, o.customer_id ";

    public Order findByOrderId(int id) {
        return jdbcTemplate.queryForObject(FIND_BY_ORDERID_SQL, BeanPropertyRowMapper.newInstance(Order.class), id);
    }
    
}
