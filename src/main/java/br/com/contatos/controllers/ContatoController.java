package br.com.contatos.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.contatos.daos.ContatoDao;
import br.com.contatos.models.Contato;

@Controller
@RequestMapping("/contatos")
@Transactional
public class ContatoController {

    @Autowired
    ContatoDao contatoDao;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Contato> list() {
	return contatoDao.all();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Contato incluir(@RequestBody Contato contato) {
	this.contatoDao.save(contato);

	return contato;
    }
}
