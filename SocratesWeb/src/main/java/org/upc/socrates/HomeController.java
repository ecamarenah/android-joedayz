/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.upc.socrates;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.upc.socrates.model.Curso;
import org.upc.socrates.model.CursoList;
import org.upc.socrates.model.Hora;
import org.upc.socrates.model.HoraList;
import org.upc.socrates.model.Nota;
import org.upc.socrates.model.NotaList;
import org.upc.socrates.model.Recurso;
import org.upc.socrates.model.RecursoList;

@Controller
@RequestMapping("/*")
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("home()");
		return "home";
	}

	@RequestMapping(value = "horas/{tab}", method = RequestMethod.GET, headers = "Accept=application/xml")
	public @ResponseBody
	HoraList getHorasXml(@PathVariable int tab) {
		logger.info("getHorasXml()");
		return new HoraList(getHoras(tab));
	}

	@RequestMapping(value = "notas", method = RequestMethod.GET, headers = "Accept=application/xml")
	public @ResponseBody
	NotaList getNotasXml() {
		logger.info("getNotasXml()");
		return new NotaList(getNotas());
	}

	@RequestMapping(value = "cursos", method = RequestMethod.GET, headers = "Accept=application/xml")
	public @ResponseBody
	CursoList getCursosXml() {
		logger.info("getCursosXml()");
		return new CursoList(getCursos());
	}

	@RequestMapping(value = "recursos", method = RequestMethod.GET, headers = "Accept=application/xml")
	public @ResponseBody
	RecursoList getRecursosXml() {
		logger.info("getRecursosXml()");
		return new RecursoList(getRecursos());
	}

	private List<Hora> getHoras(int tab) {
		List<Hora> horas = null;

		switch (tab) {
		case 0:
			horas = new ArrayList<Hora>();
			horas.add(new Hora("19:00 - 20:00", "Desarrollo movil", "UC-41", "E84A", "MO"));
			horas.add(new Hora("20:00 - 21:00", "Desarrollo movil", "UC-41", "E84A", "MO"));
			horas.add(new Hora("21:00 - 22:00", "Desarrollo movil", "UC-41", "E84A", "MO"));

			break;
		case 1:
			horas = new ArrayList<Hora>();
			horas.add(new Hora("19:00 - 20:00", "Balance Socore Card", "UA-32", "E84A", "MO"));
			horas.add(new Hora("20:00 - 21:00", "Balance Socore Card", "UA-32", "E84A", "MO"));
			horas.add(new Hora("21:00 - 22:00", "Balance Socore Card", "UA-32", "E84A", "MO"));

			break;
		case 2:
			break;
		case 3:
			horas = new ArrayList<Hora>();
			horas.add(new Hora("19:00 - 20:00", "Desarrollo movil", "UC-41", "E84A", "MO"));
			horas.add(new Hora("20:00 - 21:00", "Desarrollo movil", "UC-41", "E84A", "MO"));
			horas.add(new Hora("21:00 - 22:00", "Desarrollo movil", "UC-41", "E84A", "MO"));

			break;
		case 4:
			horas = new ArrayList<Hora>();
			horas.add(new Hora("19:00 - 20:00", "Balance Socore Card", "UA-32", "E84A", "MO"));
			horas.add(new Hora("20:00 - 21:00", "Balance Socore Card", "UA-32", "E84A", "MO"));
			horas.add(new Hora("21:00 - 22:00", "Balance Socore Card", "UA-32", "E84A", "MO"));

			break;
		case 5:
			break;
		}

		return horas;
	}

	private List<Nota> getNotas() {
		List<Nota> notas = new ArrayList<Nota>();
		notas.add(new Nota("PC 1", "20%", "15"));
		notas.add(new Nota("TP", "30%", "18"));
		return notas;
	}

	private List<Curso> getCursos() {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("IS90", "Balanced Scorecard", "16"));
		cursos.add(new Curso("IS78", "Desarrollo movil", "15"));
		cursos.add(new Curso("IS73", "Seminario de informacion", "17"));
		return cursos;
	}

	private List<Recurso> getRecursos() {
		List<Recurso> recursos = new ArrayList<Recurso>();
		recursos.add(new Recurso("72", "CUB 02 (Piso 3)", "MO", "Reservar"));
		recursos.add(new Recurso("73", "CUB 03 (Piso 3)", "MO", "Reservar"));
		recursos.add(new Recurso("74", "CUB 04 (Piso 3)", "MO", "Reservar"));
		return recursos;
	}
}
