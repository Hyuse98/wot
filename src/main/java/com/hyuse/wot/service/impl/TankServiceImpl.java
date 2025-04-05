package com.hyuse.wot.service.impl;

import com.hyuse.wot.model.Tank;
import com.hyuse.wot.repository.TankRepository;
import com.hyuse.wot.service.TankService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TankServiceImpl implements TankService {

    private final TankRepository tankRepository;

    public TankServiceImpl(TankRepository tankRepository) {
        this.tankRepository = tankRepository;
    }

    @Override
    public Tank findTankById(Long id) {
        return tankRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Tank create(Tank tank) {

        Optional<Tank> tankToCheck = tankRepository.findTankByName(tank.getName());

        if (tankToCheck.isPresent()) {
            throw new IllegalArgumentException("Tank Already Exist");
        }
        return tankRepository.save(tank);
    }
}
