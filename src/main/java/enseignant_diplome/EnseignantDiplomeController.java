package enseignant_diplome;

import com.dresen.agePers.diplome.DiplomeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class EnseignantDiplomeController {

    private DiplomeService diplomeService;


}
