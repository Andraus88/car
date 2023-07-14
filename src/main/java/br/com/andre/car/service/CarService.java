package br.com.andre.car.service;

import br.com.andre.car.dto.CarDtoRequest;
import br.com.andre.car.dto.CarDtoResponse;
import br.com.andre.car.entity.Car;
import br.com.andre.car.exception.CarNotFoundException;
import br.com.andre.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public void save(CarDtoRequest carDtoRequest) {

        Car car = new Car(
                null,
                carDtoRequest.getName(),
                carDtoRequest.getBrand(),
                carDtoRequest.getColor(),
                carDtoRequest.getFabricationYear()
        );
        carRepository.save(car);
    }

    public CarDtoResponse getByID(Long idChassi) {
        Car car =
        carRepository.findById(idChassi).orElseThrow(() -> new CarNotFoundException("Id Not Found"));

        CarDtoResponse carDtoResponse = new CarDtoResponse(
                car.getIdChassi(),
                car.getName(),
                car.getBrand(),
                car.getColor(),
                car.getFabricationYear()
        );
        return carDtoResponse;

    }
}
