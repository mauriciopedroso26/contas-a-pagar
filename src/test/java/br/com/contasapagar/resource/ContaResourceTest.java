package br.com.contasapagar.resource;

import br.com.contasapagar.ContasapagarApplication;
import br.com.contasapagar.creator.ContaCreator;
import br.com.contasapagar.creator.ContaDomainInCreator;
import br.com.contasapagar.domain.in.ContaDomainIn;
import br.com.contasapagar.domain.out.ContaDomainOut;
import br.com.contasapagar.service.ContaService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContasapagarApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContaResourceTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ContaService contaService;

    @Autowired
    private ContaCreator contaCreator;

    @Autowired
    private ContaDomainInCreator contaDomainInCreator;

    @Before
    public void init() {
        contaService.save(contaCreator.contaCreate());
    }

    @Test
    public void findAll() {
        ResponseEntity<ContaDomainOut[]> response = testRestTemplate.getForEntity("/api/admin/conta", ContaDomainOut[].class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotNull(response.getBody());
        Assert.assertNotNull(response.getBody()[0]);
    }

    @Test
    public void save(){
        ContaDomainIn contaDomainIn = contaDomainInCreator.contaDomainInCreate();
        ResponseEntity<ContaDomainOut> response = testRestTemplate.postForEntity("/api/admin/conta", contaDomainIn, ContaDomainOut.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void saveComAte3DiasDeAtraso(){
        ContaDomainIn contaDomainIn = contaDomainInCreator.contaDomainInCreateAte3DiasDeAtraso();
        ResponseEntity<ContaDomainOut> response = testRestTemplate.postForEntity("/api/admin/conta", contaDomainIn, ContaDomainOut.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(3, response.getBody().getQuantidadeDiasAtraso());
        Assert.assertEquals(102.3, response.getBody().getValorCorrigido(), 0.0001);
    }

    @Test
    public void saveSuperiorA3DiasDeAtraso(){
        ContaDomainIn contaDomainIn = contaDomainInCreator.contaDomainInCreateSuperiorA3DiasDeAtraso();
        ResponseEntity<ContaDomainOut> response = testRestTemplate.postForEntity("/api/admin/conta", contaDomainIn, ContaDomainOut.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(5, response.getBody().getQuantidadeDiasAtraso());
        Assert.assertEquals(104.05, response.getBody().getValorCorrigido(), 0.0001);
    }

    @Test
    public void saveSuperiorA5DiasDeAtraso(){
        ContaDomainIn contaDomainIn = contaDomainInCreator.contaDomainInCreateSuperiorA5DiasDeAtraso();
        ResponseEntity<ContaDomainOut> response = testRestTemplate.postForEntity("/api/admin/conta", contaDomainIn, ContaDomainOut.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(6, response.getBody().getQuantidadeDiasAtraso());
        Assert.assertEquals(106.91, response.getBody().getValorCorrigido(), 0.0001);
    }
}
