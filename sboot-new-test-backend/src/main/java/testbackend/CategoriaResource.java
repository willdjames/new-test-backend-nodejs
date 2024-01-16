package testbackend;

import java.net.URI;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categoria")
public class CategoriaResource {
    
    private static final Logger log = LoggerFactory.getLogger(CategoriaResource.class);

    private MongoTemplate mongoTemplate;

    
    @Autowired
    public CategoriaResource(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @PostMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Object> registro(@RequestBody CategoriaRequest categoria) {
        log.info("{}", categoria);

        String categoriaID = UUID.randomUUID().toString();

        categoria.categoriaID = categoriaID;

        mongoTemplate.save(categoria);

        return ResponseEntity.created(URI.create("/categoria/"+categoriaID)).build();
    }


    @PutMapping(
        path = "/{categoriaID}",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Object> atualiza(@RequestBody CategoriaRequest Categoria, 
                                            @PathVariable("categoriaID") String categoriaID) {
        log.info("categoriaID: {}", categoriaID);
        log.info("{}", Categoria);

        return ResponseEntity.accepted().build();
    }
    
    
    @DeleteMapping(
        path = "/{categoriaID}"
    )
    public ResponseEntity<Object> deleta(@PathVariable("categoriaID") String categoriaID) {
        log.info("categoriaID: {}", categoriaID);

        return ResponseEntity.accepted().build();
    }
    
    
    @GetMapping(
        path = "/{categoriaID}",
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<CategoriaRequest> acesso(@PathVariable("categoriaID") String categoriaID) {

        Query q = new Query().addCriteria(Criteria.where("categoriaID").is(categoriaID));

        CategoriaRequest categoria = mongoTemplate.findOne(q, CategoriaRequest.class);

        log.info("{}", categoria);

        return ResponseEntity.ok(categoria);
    }
}
