//package hello.DAO;
//
//import hello.DAO.Entity.Rate;
//import hello.DAO.Repositories.RateCrudRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class RateTest {
//    @Resource
//    private RateCrudRepository rateCrudRepository;
//
//    @Test
//    public void givenRate_whenSave_thenGetOk() throws ParseException {
//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        Date date = simpleDateFormat.parse("2019-10-10");
//        Rate rateTable = new Rate(65.,date);
//        rateCrudRepository.save(rateTable);
//        assertEquals(65., rateCrudRepository.findById(1L).map(rate -> rate.getRate()).get(),0.1);
//    }
//}