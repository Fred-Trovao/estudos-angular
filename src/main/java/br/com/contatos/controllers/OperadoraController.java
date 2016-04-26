package br.com.contatos.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.contatos.daos.OperadoraDao;
import br.com.contatos.models.Operadora;

@Controller
@RequestMapping("/operadoras")
@Transactional
public class OperadoraController {

    @Autowired
    OperadoraDao operadoraDao;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Operadora> list() {
	return operadoraDao.all();
    }
}
