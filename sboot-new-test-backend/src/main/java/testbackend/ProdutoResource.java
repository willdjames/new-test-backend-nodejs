package testbackend;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/produto")
public class ProdutoResource {
    
    private static final Logger log = LoggerFactory.getLogger(ProdutoResource.class);

    @PostMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Object> registro(@RequestBody ProdutoRequest produto) {
        log.info("{}", produto);

        return ResponseEntity.created(URI.create("/produto")).build();
    }
    

    @GetMapping(
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<ProdutoRequest> acesso() {
        CategoriaRequest categoria = new CategoriaRequest("", "", "");  
        ProdutoRequest produto = new ProdutoRequest("A" ,"A", "A", categoria, "Z");

        log.info("{}", produto);

        return ResponseEntity.ok(produto);
    }
}
