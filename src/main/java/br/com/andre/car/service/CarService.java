package br.com.andre.car.service;

import br.com.andre.car.entity.Car;
import br.com.andre.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public String getString() {
            return "Dentro do service";
        }

    public Car save(Car car) {
        carRepository.save(car);
        return car;
    }

    public Car getByID(Long idChassi) {
        return carRepository.getById(idChassi);
    }
}
