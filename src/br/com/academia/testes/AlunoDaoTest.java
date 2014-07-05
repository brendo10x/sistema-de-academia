package br.com.academia.testes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.ALOAD;

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

public class AlunoDaoTest {

	private AlunoDao dao = new AlunoDao();
	private Aluno aluno;

	private Integer ID_EXCLUSAO = 22;
	private Integer ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR = 22;

	@Test
	@Ignore
	public void testSalvar() {
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

		// Contato

		List<Contato> contatos = new ArrayList<>();
		Contato contato = new Contato();
		contato.setTipo(TipoContato.EMAIL);
		contato.setValor("brendo10x@gmail.com");
		contato.setAlunoId(aluno);

		Contato contato2 = new Contato();
		contato2.setTipo(TipoContato.TELEFONE);
		contato2.setValor("brendo10x@gmail.com");
		contato2.setAlunoId(aluno);

		contatos.add(contato);
		contatos.add(contato2);

		aluno.setContatoList(contatos);

		// Observação

		List<Observacao> observacaoLista = new ArrayList<>();
		Observacao observacao = new Observacao();
		observacao.setValor("Observaçãooo");
		observacao.setAlunoId(aluno);

		observacaoLista.add(observacao);

		aluno.setObservacaoList(observacaoLista);

		PerguntaDao perguntaDao = new PerguntaDao();
		Pergunta pergunta = perguntaDao.carregar(2);

		List<ValorObservacao> valorObservacaoList = new ArrayList<>();

		ValorObservacao valorObservacao = new ValorObservacao();
		valorObservacao.setResposta(TipoResposta.NAO);
		valorObservacao.setObservacaoId(observacao);
		valorObservacao.setPerguntaId(pergunta);
		valorObservacaoList.add(valorObservacao);

		observacao.setValorObservacaoList(valorObservacaoList);

		List<AlunoMedida> alunoMedidaList = new ArrayList<>();

		// Aluno Medida
		AlunoMedida alunoMedida = new AlunoMedida();
		alunoMedida.setAlunoId(aluno);
		alunoMedida.setInicio(new Date());

		List<AlunoTemMedida> alunoTemMedidaList = new ArrayList<>();

		alunoMedidaList.add(alunoMedida);

		aluno.setAlunoMedidaList(alunoMedidaList);

		// Medida
		MedidaDao medidaDao = new MedidaDao();
		Medida medida = medidaDao.carregar(22);

		List<ValorMedida> valorMedidaList = new ArrayList<>();

		// Aluno tem medida
		AlunoTemMedida alunoTemMedida = new AlunoTemMedida();
		alunoTemMedida.setAlunoMedidaId(alunoMedida);
		alunoTemMedida.setMedidaId(medida);

		alunoTemMedidaList.add(alunoTemMedida);

		alunoMedida.setAlunoTemMedidaList(alunoTemMedidaList);

		// Valor medida
		ValorMedida valorMedida1 = new ValorMedida();
		valorMedida1.setMembro(TipoMembro.DIREITO);
		valorMedida1.setValor(10.0);
		valorMedida1.setAlunoTemMedidaId1(alunoTemMedida);
		valorMedidaList.add(valorMedida1);

		// Valor medida 2
		ValorMedida valorMedida2 = new ValorMedida();
		valorMedida2.setMembro(TipoMembro.ESQUERDO);
		valorMedida2.setValor(9.0);
		valorMedida2.setAlunoTemMedidaId1(alunoTemMedida);
		valorMedidaList.add(valorMedida2);

		alunoTemMedida.setValorMedidaList(valorMedidaList);

		dao.salvar(aluno);

	}

	@Test
	@Ignore
	public void testCarregar() {
		aluno = dao.carregar(ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR);

		// Aluno
		System.out.println("-- Aluno ---");
		System.out.println(aluno.getNome());

		// Contato
		System.out.println("-- Contato ---");
		for (Contato contato : aluno.getContatoList()) {
			System.out.println(contato.getTipo());
			System.out.println(contato.getValor());
		}

		// Observação
		System.out.println("-- Observação ---");
		for (Observacao obs : aluno.getObservacaoList()) {
			System.out.println(obs.getValor());

			for (ValorObservacao valoObs : obs.getValorObservacaoList()) {
				Pergunta pergunta = valoObs.getPerguntaId();
				System.out.println(pergunta.getDescricao());
				System.out.println(valoObs.getResposta());

			}
		}

		// Endereço
		System.out.println("-- Endereço --");
		System.out.println(aluno.getEnderecoId().getRua());

		// Medida
		System.out.println("-- Medida --");
		for (AlunoMedida aluMed : aluno.getAlunoMedidaList()) {
			System.out.println(aluMed.getInicio());

			for (AlunoTemMedida aluTemMed : aluMed.getAlunoTemMedidaList()) {
				System.out.println(aluTemMed.getMedidaId().getLocal());

				for (ValorMedida valMed : aluTemMed.getValorMedidaList()) {
					System.out.println(valMed.getMembro());
					System.out.println(valMed.getValor());
				}
			}
		}
	}

	@Test
	@Ignore
	public void testExcluir() {

		dao.excluir(ID_EXCLUSAO);
	}

	@Test
	public void testAtualizar() {

		aluno = dao.carregar(ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR);
		aluno.setNome("Localzinho");
		dao.atualizar(aluno);
	}

	@Test
	@Ignore
	public void testListar() {

		List<Aluno> alunos = dao.listarTodos();
		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome());

		}
	}

}
