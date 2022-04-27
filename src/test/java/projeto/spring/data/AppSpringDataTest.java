package projeto.spring.data;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.dao.InterfaceSpringDataUser;
import projeto.spring.data.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {

	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Test
	public void testeInsert() {
		UsuarioSpringData usuario = new UsuarioSpringData();
		usuario.setEmail("matheus@email.com");
		usuario.setIdade(23);
		usuario.setLogin("matheus");
		usuario.setSenha("1234");
		usuario.setNome("matheus");
		
		interfaceSpringDataUser.save(usuario);
		System.out.println("Usuários cadastrados: " + interfaceSpringDataUser.count());
	}
	
	@Test
	public void testeConsulta() {
		
		Optional<UsuarioSpringData> usuario = interfaceSpringDataUser.findById(2L);
		
		System.out.println(usuario.get().getId());
		System.out.println(usuario.get().getNome());
		System.out.println(usuario.get().getEmail());
		System.out.println(usuario.get().getLogin());
		System.out.println(usuario.get().getIdade());
		System.out.println(usuario.get().getSenha());

	}
	
	@Test
	public void testeConsultaTodos() {
		
		Iterable<UsuarioSpringData> usuarios = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuario : usuarios) {
			
			System.out.println(usuario.getId());
			System.out.println(usuario.getNome());
			System.out.println(usuario.getEmail());
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getIdade());
			System.out.println(usuario.getSenha());
			System.out.println("============================");
		}

	}
	
	@Test
	public void testeUpdate() {
		
		Optional<UsuarioSpringData> usuarioData = interfaceSpringDataUser.findById(2L);
		
		UsuarioSpringData usuario = usuarioData.get();
		
		usuario.setNome("Nome alterado");
		
		interfaceSpringDataUser.save(usuario);

	}
	
	@Test
	public void testeDelete() {
		
		Optional<UsuarioSpringData> usuarioData = interfaceSpringDataUser.findById(3L);
		
		UsuarioSpringData usuario = usuarioData.get();
		
		interfaceSpringDataUser.delete(usuario);

	}
	
	
}
