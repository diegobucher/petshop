package com.diego.petshop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diego.petshop.domain.Categoria;
import com.diego.petshop.domain.Cidade;
import com.diego.petshop.domain.Cliente;
import com.diego.petshop.domain.Endereco;
import com.diego.petshop.domain.Especie;
import com.diego.petshop.domain.Estado;
import com.diego.petshop.domain.Funcionario;
import com.diego.petshop.domain.Pagamento;
import com.diego.petshop.domain.PagamentoCartao;
import com.diego.petshop.domain.PagamentoDinheiro;
import com.diego.petshop.domain.Pet;
import com.diego.petshop.domain.Produto;
import com.diego.petshop.domain.Raca;
import com.diego.petshop.domain.Servico;
import com.diego.petshop.domain.enuns.SituacaoPagamento;
import com.diego.petshop.repository.CategoriaRepository;
import com.diego.petshop.repository.CidadeRepository;
import com.diego.petshop.repository.EnderecoRepository;
import com.diego.petshop.repository.EspecieRepository;
import com.diego.petshop.repository.EstadoRepository;
import com.diego.petshop.repository.PagamentoRepository;
import com.diego.petshop.repository.PessoaRepository;
import com.diego.petshop.repository.PetRepository;
import com.diego.petshop.repository.ProdutoRepository;
import com.diego.petshop.repository.RacaRepository;
import com.diego.petshop.repository.ServicoRepository;

@Component
public class PopulaDados {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	EspecieRepository especieRepository;

	@Autowired
	RacaRepository racaRepository;

	@Autowired
	PetRepository petRepository;

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	ServicoRepository servicoRepository;

	@Autowired
	PagamentoRepository pagamentoRepository;

	// @PostConstruct
	public void cadastrar() throws ParseException {
		Categoria categoria01 = new Categoria(null, "Alimento");
		Categoria categoria02 = new Categoria(null, "Remédio");
		Categoria categoria03 = new Categoria(null, "Cosmético");

		Produto produto01 = new Produto(null, "Ração", 100.0);
		Produto produto02 = new Produto(null, "Sache", 80.0);
		Produto produto03 = new Produto(null, "Vermifugo", 20.0);
		Produto produto04 = new Produto(null, "Shampoo", 50.0);

		categoria01.getProdutos().addAll(Arrays.asList(produto01, produto02));
		categoria02.getProdutos().addAll(Arrays.asList(produto03, produto04));
		categoria03.getProdutos().addAll(Arrays.asList(produto04));

		produto01.getCategorias().addAll(Arrays.asList(categoria01));
		produto02.getCategorias().addAll(Arrays.asList(categoria01));
		produto03.getCategorias().addAll(Arrays.asList(categoria02));
		produto04.getCategorias().addAll(Arrays.asList(categoria02, categoria03));

		categoriaRepository.saveAll(Arrays.asList(categoria01, categoria02, categoria03));
		produtoRepository.saveAll(Arrays.asList(produto01, produto02, produto03, produto04));

		Especie especie01 = new Especie(null, "Cachorro");
		Especie especie02 = new Especie(null, "Gato");

		Raca raca01 = new Raca(null, "Shitzu");
		Raca raca02 = new Raca(null, "Akita");
		Raca raca03 = new Raca(null, "Persa");

		Pet pet01 = new Pet(null, "John", 6, especie01, raca01);
		Pet pet02 = new Pet(null, "Hana", 5, especie01, raca02);
		Pet pet03 = new Pet(null, "Mewth", 8, especie02, raca03);

		especieRepository.saveAll(Arrays.asList(especie01, especie02));
		racaRepository.saveAll(Arrays.asList(raca01, raca02, raca03));
		petRepository.saveAll(Arrays.asList(pet01, pet02, pet03));

		Estado estado01 = new Estado(null, "Minas Gerais");
		Estado estado02 = new Estado(null, "São Paulo");

		Cidade cidade01 = new Cidade(null, "Belo Horizonte", estado01);
		Cidade cidade02 = new Cidade(null, "Capelinha", estado01);
		Cidade cidade03 = new Cidade(null, "São Paulo", estado02);

		estado01.getCidades().addAll(Arrays.asList(cidade01, cidade02));
		estado02.getCidades().addAll(Arrays.asList(cidade03));

		estadoRepository.saveAll(Arrays.asList(estado01, estado02));
		cidadeRepository.saveAll(Arrays.asList(cidade01, cidade02, cidade03));

		Cliente cliente01 = new Cliente(null, "Jose Maria", "jose@mail.com", "335.194.320-21", "FISICA");
		cliente01.getTelefones().addAll(Arrays.asList("3516-2000", "9191-0000"));

		Funcionario funcionario01 = new Funcionario(null, "Maria Jose", "maria@mail.com", "551.872.200-12", "ATENDENTE");
		funcionario01.getTelefones().addAll(Arrays.asList("3279-0001", "9090-0002"));

		Endereco endereco01 = new Endereco(null, "Rua Tupis", "500", "Apto 101", "Pindorama", "30111222", cliente01, cidade01);
		Endereco endereco02 = new Endereco(null, "Av. Tamoios", "100", "Casa", "Oca", "3968000", funcionario01, cidade02);
		Endereco endereco03 = new Endereco(null, "Rua Aranãs", "10", "Apto 201", "Centro", "01153000", funcionario01, cidade03);

		pessoaRepository.saveAll(Arrays.asList(cliente01, funcionario01));
		enderecoRepository.saveAll(Arrays.asList(endereco01, endereco02, endereco03));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Servico servico01 = new Servico(null, sdf.parse("02/09/2021 09:00"), sdf.parse("02/09/2021 12:00"), "Tosa", null, cliente01, funcionario01, pet01);
		Servico servico02 = new Servico(null, sdf.parse("03/09/2021 12:00"), sdf.parse("04/09/2021 12:00"), "Hotel", null, cliente01, funcionario01, pet02);
		Servico servico03 = new Servico(null, sdf.parse("05/09/2021 16:00"), sdf.parse("05/09/2021 16:30"), "Vermifugação", null, cliente01, funcionario01, pet03);

		Pagamento pagamento01 = new PagamentoCartao(null, 60.0, SituacaoPagamento.QUITADO, servico02, 6);
		servico02.setPagamento(pagamento01);

		Pagamento pagamento02 = new PagamentoDinheiro(null, 100.0, SituacaoPagamento.PENDENTE, servico01, sdf.parse("02/09/2021 00:00"), null);
		servico01.setPagamento(pagamento02);

		Pagamento pagamento03 = new PagamentoDinheiro(null, 75.0, SituacaoPagamento.QUITADO, servico03, sdf.parse("05/09/2021 16:30"), null);
		servico03.setPagamento(pagamento03);

		cliente01.getServicos().addAll(Arrays.asList(servico01, servico02));
		funcionario01.getServicos().addAll(Arrays.asList(servico01, servico02));

		servico02.getProdutos().addAll(Arrays.asList(produto01, produto02, produto04));
		servico03.getProdutos().addAll(Arrays.asList(produto03));

		servicoRepository.saveAll(Arrays.asList(servico01, servico02, servico03));
		pagamentoRepository.saveAll(Arrays.asList(pagamento01, pagamento02, pagamento03));
	}

}
