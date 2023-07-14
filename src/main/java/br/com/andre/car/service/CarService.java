package br.com.andre.car.service;

import br.com.andre.car.dto.CarDtoRequest;
import br.com.andre.car.dto.CarDtoResponse;
import br.com.andre.car.entity.Car;
import br.com.andre.car.exception.CarBrandNotAllowedException;
import br.com.andre.car.exception.CarNotFoundException;
import br.com.andre.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public void save(CarDtoRequest carDtoRequest) throws CarBrandNotAllowedException {


        Car car = new Car(
                null,
                carDtoRequest.getName(),
                carDtoRequest.getBrand(),
                carDtoRequest.getColor(),
                carDtoRequest.getFabricationYear()
        );

        List<String> allowedBrands = Arrays.asList("Ford", "Chevrolet", "BMW", "Volvo");
        if (allowedBrands.contains(car.getBrand())) {
            carRepository.save(car);
        } else {
            throw new CarBrandNotAllowedException("Brand is not allowed!");
        }
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