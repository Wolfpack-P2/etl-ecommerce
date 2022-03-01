package com.revature.repositories;

import com.revature.models.Order;
import com.revature.models.QueryResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Transactional
    @Query(value = "SELECT PRODUCT_CATEGORY, COUNT(PRODUCT_CATEGORY) FROM ETL.ORDERS GROUP BY PRODUCT_CATEGORY")
    List<QueryResult> findCategory();

    @Modifying
    @Transactional
    @Query(value = "SELECT PRODUCT_CATEGORY, COUNTRY, COUNT(PRODUCT_CATEGORY) FROM ETL.ORDERS GROUP BY PRODUCT_CATEGORY, COUNTRY")
    List<QueryResult> findCategoryCountry();

    @Modifying
    @Transactional
    @Query(value = "SELECT PRODUCT_CATEGORY, MONTH(DATETIME) AS MONTH, COUNT(PRODUCT_CATEGORY) FROM ETL.ORDERS GROUP BY MONTH")
    List<QueryResult> findYearPopularity();

    @Modifying
    @Transactional
    @Query(value = "SELECT PRODUCT_CATEGORY, COUNTRY, MONTH(DATETIME) AS MONTH, COUNT(PRODUCT_CATEGORY) FROM ETL.ORDERS GROUP BY MONTH")
    List<QueryResult> findYearPopularityCountry();

    @Modifying
    @Transactional
    @Query(value = "SELECT COUNTRY, COUNT(COUNTRY) FROM ETL.ORDERS GROUP BY COUNTRY")
    List<QueryResult> findTopCountry();

    @Modifying
    @Transactional
    @Query(value = "SELECT DATEPART(HH,DATETIME) AS HOUR, COUNT(HOUR) FROM ETL.ORDERS GROUP BY HOUR")
    List<QueryResult> findBusiestTime();

    @Modifying
    @Transactional
    @Query(value = "SELECT DATEPART(HH,DATETIME) AS HOUR, COUNTRY, COUNT(HOUR) FROM ETL.ORDERS GROUP BY HOUR, COUNTRY")
    List<QueryResult> findBusiestTimeCountry();
}
