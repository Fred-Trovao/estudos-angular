angular.module("listaTelefonica").factory("contatosAPI", function($http, config) {
	
	var _urlContatos = config.baseUrl + "contatos";
	
	var _getContatos = function() {
		return $http.get(_urlContatos);
	};
	
	var _saveContato = function(contato) {
		return $http.post(_urlContatos, contato)
	};
	
	return {
		getContatos: _getContatos,
		saveContato: _saveContato
	};
});