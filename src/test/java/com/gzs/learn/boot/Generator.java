package com.gzs.learn.boot;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.gzs.learn.boot.entity.TestHb;

public class Generator {
    public static void main(String[] args) throws IOException, XMLParserException,
            InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();

        boolean overwrite = true;
        InputStream inputStream = Generator.class.getResourceAsStream("/generator.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(inputStream);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void testEqual() throws Exception {
        TestHb hb = new TestHb();
        hb.setAddress("");
        Field[] fields = hb.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if(f.get(hb) != null && f.get(hb) != ""){
                System.out.println("121");
            }
        }
        //System.out.println(hb.getAddress() != "");
    }
}
