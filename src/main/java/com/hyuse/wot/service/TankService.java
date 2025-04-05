package com.hyuse.wot.service;

import com.hyuse.wot.model.Tank;

public interface TankService {

    Tank findTankById(Long id);

    Tank create(Tank tank);
}
