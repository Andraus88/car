package br.com.andre.car.repository;

import br.com.andre.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository <Car, Long> {
}
