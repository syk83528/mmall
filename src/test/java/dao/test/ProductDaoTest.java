package dao.test;

import com.mmall.dao.ProductMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.TestBase;

import java.util.List;
import java.util.Map;

/**
 * Created by syk on 2018/4/11.
 */
public class ProductDaoTest extends TestBase {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testDao(){

        List<Map<String, Object>> products = productMapper.getProductAAAAByProductId(26);
        System.out.println(products);
    }
}
