package com.zc.service;

import com.zc.mapper.HeroMapper;
import com.zc.pojo.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService{
    @Autowired
    private HeroMapper heroMapper;

    @Override
    public List<Hero> getAllHero() {
        return heroMapper.selectAll();
    }

    @Override
    public void addHero(Hero hero) {
        heroMapper.insert(hero);
    }

    @Override
    public Hero selectOne(Integer id) {
        return  heroMapper.selectByPrimaryKey(id);
    }

    @Override
    public void alterHero(Hero hero) {
        heroMapper.updateByPrimaryKey(hero);
    }

    @Override
    public void deleteHero(Integer id) {
        heroMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Hero getHero(Integer id) {

        return heroMapper.selectByPrimaryKey(id);
    }
}
