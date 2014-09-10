package com.realdolmen.course;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.metamodel.relational.Database;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSetPersistenceTest extends PersistenceTest {

    private static final Logger logger = LoggerFactory.getLogger(DataSetPersistenceTest.class);

    @Before
    public void loadDataSet() throws Exception {

        logger.info("Loading dataset");

        Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(getClass().getResource("/data.xml"));

        DatabaseConfig dbConfig = connection.getConfig();
        dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());

        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
    }

}
