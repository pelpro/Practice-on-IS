package hello;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest
public class RBCServiceTest {

//    private RBKService serviceMock = mock(RBKService.class);

    @Mock
    private RBCService serviceMock;

    String data = "USD000000TOD,2019-09-10,65.44,65.55,65.3125,65.48,558467000,65.4491\n" +
            "USD000000TOD,2019-09-11,65.4025,65.4875,65.2825,65.4025,508890000,65.3835\n" +
            "USD000000TOD,2019-09-12,65.37,65.37,64.74,64.8,834418000,65.0667\n" +
            "USD000000TOD,2019-09-13,64.2225,64.7175,64.125,64.2725,725046000,64.3306\n" +
            "USD000000TOD,2019-09-16,63.835,64.1675,63.57,64,1367191000,63.9049\n" +
            "USD000000TOD,2019-09-17,64.03,64.44,63.97,64.3575,725278000,64.184\n" +
            "USD000000TOD,2019-09-18,64.405,64.4975,64.1325,64.2,563604000,64.3745\n" +
            "USD000000TOD,2019-09-19,64.2875,64.325,63.8075,63.825,602279000,64.1152\n" +
            "USD000000TOD,2019-09-20,63.8575,63.9975,63.68,63.955,602902000,63.8162\n" +
            "USD000000TOD,2019-09-23,63.9275,64.0675,63.84,63.965,519631000,63.9509\n" +
            "USD000000TOD,2019-09-24,63.735,63.7875,63.6,63.7825,492878000,63.6845\n" +
            "USD000000TOD,2019-09-25,64.0375,64.4775,63.9925,64.4,944253000,64.2578\n" +
            "USD000000TOD,2019-09-26,64.32,64.37,64.095,64.3325,603439000,64.2645\n" +
            "USD000000TOD,2019-09-27,64.34,64.4375,64.26,64.305,727986000,64.3603\n" +
            "USD000000TOD,2019-09-30,64.65,65,64.57,64.96,826782000,64.7697\n" +
            "USD000000TOD,2019-10-01,64.955,65.37,64.95,65.3475,699118000,65.1026\n" +
            "USD000000TOD,2019-10-02,65.3475,65.5575,65.0225,65.2375,647424000,65.3354\n" +
            "USD000000TOD,2019-10-03,65.085,65.3675,65.0225,65.2175,652828000,65.1126\n" +
            "USD000000TOD,2019-10-04,65.01,65.0925,64.51,64.5375,814237000,64.8713\n" +
            "USD000000TOD,2019-10-07,64.675,64.97,64.675,64.8575,515837000,64.8634\n" +
            "USD000000TOD,2019-10-08,64.8375,65.3625,64.7525,65.2875,652387000,65.058\n" +
            "USD000000TOD,2019-10-09,65.19,65.195,64.8075,64.9,622432000,64.981";




    @Before
    public void setUp() throws Exception {
        Mockito.when(serviceMock.getResponse()).thenReturn(data);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void parseResponse() {
        ArrayList<Double> strings = new ArrayList<>();
        for (double i = 0; i < 5;i += 1){
            strings.add(i);
        }
        RBCService service = new RBCService();
        String testString = "0.0\n"+ "1.0\n"+"2.0\n"+"3.0\n"+"4.0\n";
        assertEquals(strings,(service.parseResponse(testString)));
    }

//    @Test
//    public void getMaxFromArray() {
//        ArrayList<Double> test = new ArrayList<>();
//        for (double i = 0; i < 1000; i += 1) {
//            test.add(i);
//        }
//        RBCService service = new RBCService();
//        Mockito.when(serviceMock.parseResponse(Mockito.anyString())).thenReturn(test);
//        assertEquals(99, service.getMaxFromArray(serviceMock.parseResponse(data)), 0.1);
//    }
}