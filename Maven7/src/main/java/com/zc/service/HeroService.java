package com.zc.service;

import com.zc.pojo.Hero;

import java.util.List;

public interface HeroService {
    public List<Hero> getAllHero();

    void addHero(Hero hero);

    Hero selectOne(Integer id);

    void alterHero(Hero hero);

    void deleteHero(Integer id);

    Hero getHero(Integer id);
}
