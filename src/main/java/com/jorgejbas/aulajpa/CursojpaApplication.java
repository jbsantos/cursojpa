package com.jorgejbas.aulajpa;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jorgejbas.aulajpa.domain.Categoria;
import com.jorgejbas.aulajpa.domain.Cidade;
import com.jorgejbas.aulajpa.domain.Cliente;
import com.jorgejbas.aulajpa.domain.Endereco;
import com.jorgejbas.aulajpa.domain.Estado;
import com.jorgejbas.aulajpa.domain.Pagamento;
import com.jorgejbas.aulajpa.domain.PagamentoComBoleto;
import com.jorgejbas.aulajpa.domain.PagamentoComCartao;
import com.jorgejbas.aulajpa.domain.Pedido;
import com.jorgejbas.aulajpa.domain.Produto;
import com.jorgejbas.aulajpa.domain.enums.EstadoPagamento;
import com.jorgejbas.aulajpa.domain.enums.TipoCliente;
import com.jorgejbas.aulajpa.repositories.CategoriaRepository;
import com.jorgejbas.aulajpa.repositories.CidadeRepository;
import com.jorgejbas.aulajpa.repositories.ClienteRepository;
import com.jorgejbas.aulajpa.repositories.EnderecoRepository;
import com.jorgejbas.aulajpa.repositories.EstadoRepository;
import com.jorgejbas.aulajpa.repositories.PagamentoRepository;
import com.jorgejbas.aulajpa.repositories.PedidoRepository;
import com.jorgejbas.aulajpa.repositories.ProdutoRepository;


@SpringBootApplication
public class CursojpaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtorepository;
	@Autowired
	private CidadeRepository cidaderepository;
	
	@Autowired
	private EstadoRepository estadorepository;

	@Autowired
	private ClienteRepository clienterepository;
	
	@Autowired
	private EnderecoRepository enderecorepository;
	
	@Autowired
	private PagamentoRepository pagamentorepository;
	
	@Autowired
	private PedidoRepository pedidorepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursojpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		int indice = 0;
		Categoria cat1 = new Categoria(0,"Informática");
		Categoria cat2 = new Categoria (0,"escritório");
		
		Produto p1 = new Produto(1, "Computador", 2000.00);
		Produto p2 = new Produto(2, "Impressora", 800.00);
		Produto p3 = new Produto(3, "Mause", 80.00);	
		
		cat1.getProduto().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProduto().addAll(Arrays.asList(p2));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtorepository.save(Arrays.asList(p1,p2,p3));
		
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadorepository.save(Arrays.asList(est1,est2));
		cidaderepository.save(Arrays.asList(c1,c2,c3));
		
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apt 303", "Jardim", "123456789", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienterepository.save(Arrays.asList(cli1));
		enderecorepository.save(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2019 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2019 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2019 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedido().addAll(Arrays.asList(ped1,ped2));
		
		pedidorepository.save(Arrays.asList(ped1,ped2));
		pagamentorepository.save(Arrays.asList(pagto1, pagto2));
	}

}

























