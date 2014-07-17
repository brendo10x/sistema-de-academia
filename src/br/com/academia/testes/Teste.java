package br.com.academia.testes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.academia.dao.AlunoDao;
import br.com.academia.dao.CidadeDao;
import br.com.academia.dao.EnderecoDao;
import br.com.academia.dao.MedidaDao;
import br.com.academia.dao.PerguntaDao;
import br.com.academia.enums.TipoContato;
import br.com.academia.enums.TipoMembro;
import br.com.academia.enums.TipoResposta;
import br.com.academia.enums.TipoSexo;
import br.com.academia.modelo.Aluno;
import br.com.academia.modelo.AlunoMedida;
import br.com.academia.modelo.AlunoTemMedida;
import br.com.academia.modelo.Cidade;
import br.com.academia.modelo.Contato;
import br.com.academia.modelo.Endereco;
import br.com.academia.modelo.Medida;
import br.com.academia.modelo.Observacao;
import br.com.academia.modelo.Pergunta;
import br.com.academia.modelo.ValorMedida;
import br.com.academia.modelo.ValorObservacao;

public class Teste {
	
	public static void main(String[] args) {
		
		AlunoDao dao = new AlunoDao();
	  Aluno aluno;
	aluno = new Aluno();

	// Propriedades
	aluno.setNome("Brendo Felipe");
	aluno.setAltura(2.0);
	aluno.setCodigoAcesso("12000");
	aluno.setDataNascimento(new Date());
	aluno.setPeso(70.10);
	aluno.setSexo(TipoSexo.MASCULINO);

	// Endereço
	Endereco endereco = new Endereco();
	endereco.setBairro("Bairro valo");
	endereco.setCep("Cep");
	endereco.setNumero("Número valor");
	endereco.setRua("Ruaaa");

	CidadeDao cidadeDao = new CidadeDao();
	Cidade cidade = cidadeDao.carregar(1);
	endereco.setCidadeId(cidade);

	EnderecoDao enderecoDao = new EnderecoDao();
	enderecoDao.salvar(endereco);

	aluno.setEnderecoId(endereco);

	dao.salvar(aluno);

	}
}