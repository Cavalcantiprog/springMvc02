package br.com.cotiinformatica.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;

@Service //define como classe de serviço do Spring
@Transactional //permite o uso de transações de banco de dados
public class UsuarioService {

	@Autowired //injeção de dependência
	private IUsuarioRepository usuarioRepository;
	
	//método para salvar/atualizar um usuário no banco de dados
	public void createOrUpdate(Usuario usuario) throws Exception {
		
		//verificar se o email informado já está cadastrado
		if(usuario.getIdUsuario() == null && usuarioRepository.get(usuario.getEmail()).size() == 1)
			throw new Exception("O email informado já encontra-se cadastrado.");
		
		usuarioRepository.save(usuario);
	}
	
	//método para excluir um usuário no banco de dados
	public void delete(Usuario usuario) throws Exception {
		usuarioRepository.delete(usuario);
	}
	
	//método para consultar todos os usuários do banco de dados
	public List<Usuario> getAll() throws Exception {
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	//método para obter 1 usuário por id
	public Usuario get(Integer id) throws Exception{
		return usuarioRepository.findById(id).get();
	}
	
	//método para buscar 1 usuário no banco de dados atraves do email e senha
	public Usuario get(String email, String senha) throws Exception{
		List<Usuario> result = usuarioRepository.get(email, senha);
		
		if(result.size() == 1)
			return result.get(0); //retornando o usuario obtido
		
		return null;
	}
}
