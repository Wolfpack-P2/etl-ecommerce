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
    @Query(value = "SELECT PRODUCT_CATEGORY, COUNT(PRODUCT_CATEGORY) FROM ETL.ORDERS GROUP BY PRODUCT_CATEGORY", nativeQuery = true)
    List<QueryResult> findCategory();

    @Modifying
    @Transactional
    @Query(value = "SELECT PRODUCT_CATEGORY, COUNTRY, COUNT(PRODUCT_CATEGORY) FROM ETL.ORDERS GROUP BY PRODUCT_CATEGORY, COUNTRY", nativeQuery = true)
    List<QueryResult> findCategoryCountry();

    @Modifying
    @Transactional
    @Query(value = "SELECT PRODUCT_CATEGORY, EXTRACT(MONTH FROM DATETIME) AS MONTH, COUNT(PRODUCT_CATEGORY) FROM ETL.ORDERS GROUP BY PRODUCT_CATEGORY, MONTH", nativeQuery = true)
    List<QueryResult> findYearPopularity();

    @Modifying
    @Transactional
    @Query(value = "SELECT PRODUCT_CATEGORY, COUNTRY, EXTRACT(MONTH FROM DATETIME) AS MONTH, COUNT(PRODUCT_CATEGORY) FROM ETL.ORDERS GROUP BY PRODUCT_CATEGORY, COUNTRY, MONTH", nativeQuery = true)
    List<QueryResult> findYearPopularityCountry();

    @Modifying
    @Transactional
    @Query(value = "SELECT COUNTRY, COUNT(COUNTRY) FROM ETL.ORDERS GROUP BY COUNTRY", nativeQuery = true)
    List<QueryResult> findTopCountry();

    @Modifying
    @Transactional
    @Query(value = "SELECT EXTRACT(HOUR FROM DATETIME) AS HOUR, COUNT(EXTRACT(HOUR FROM DATETIME)) FROM ETL.ORDERS GROUP BY HOUR", nativeQuery = true)
    List<QueryResult> findBusiestTime();

    @Modifying
    @Transactional
    @Query(value = "SELECT EXTRACT(HOUR FROM DATETIME) AS HOUR, COUNTRY, COUNT(EXTRACT(HOUR FROM DATETIME)) FROM ETL.ORDERS GROUP BY HOUR, COUNTRY", nativeQuery = true)
    List<QueryResult> findBusiestTimeCountry();
}
