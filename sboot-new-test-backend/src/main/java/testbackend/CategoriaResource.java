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
@RequestMapping("/categoria")
public class CategoriaResource {
    
    private static final Logger log = LoggerFactory.getLogger(CategoriaResource.class);

    @PostMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Object> registro(@RequestBody CategoriaRequest Categoria) {
        log.info("{}", Categoria);

        return ResponseEntity.created(URI.create("/categoria")).build();
    }
    
    
    @GetMapping(
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<CategoriaRequest> acesso() {
        CategoriaRequest categoria = new CategoriaRequest("A" ,"A", "A");

        log.info("{}", categoria);

        return ResponseEntity.ok(categoria);
    }
}
