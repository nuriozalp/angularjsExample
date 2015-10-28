package com.xvitcoder.angualrspringapp.controller;

import com.xvitcoder.angualrspringapp.service.CarService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/carlist.json")
    public @ResponseBody List<String> getCarList( HttpServletResponse response) throws IOException {
     
         try {
        //  throw new Exception("hata oluştu");
        } catch (Exception e) {
              
         response.sendError(1001,e.getMessage() );
        }  
         return carService.getAllCars();
    }

    @RequestMapping(value = "/addCar/{car}", method = RequestMethod.POST)
    public @ResponseBody void addCar(@PathVariable("car") String car, HttpServletResponse response) throws IOException {
        carService.addCar(car);
        try {
            throw new Exception("hata oluştur");
          
        } catch (Exception e) {
             response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );   
          //response.sendError(1001, "hata oluştur");
        }
    }
       
    @RequestMapping(value = "/removeCar/{car}", method = RequestMethod.DELETE)
    public @ResponseBody void removeCar(@PathVariable("car") String car) {
        carService.deleteCar(car);
    }

    @RequestMapping(value = "/removeAllCars", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllCars() {
        carService.deleteAll();
    }

    @RequestMapping("/layout")
    public String getCarPartialPage() {
        return "cars/layout";
    }
}
