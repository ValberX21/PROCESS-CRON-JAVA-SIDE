package firstpalace.processslice.controller;

import firstpalace.processslice.Service.ProcessLot;
import firstpalace.processslice.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/calculate/productslot")
public class CalculateProductLotController {

    private final ProcessLot _processLot;

    public CalculateProductLotController(ProcessLot processLot)
    {
        this._processLot = processLot;
    }

    @GetMapping("/testApi")
    public String testApi() {
        return "API is running 🚀";
    }

    @PostMapping("/getLog")
    public ResponseEntity<?> processLot(@RequestBody List<Product> productList)
    {
        try{
            if (productList.size() > 50) {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "Maximum register is 50");
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(errorResponse);
            }

            Long result = _processLot.process(productList);

            if(result != null){
                return ResponseEntity.status(200).body(result);
            }else{
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error processing products");
            }
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing products: " + e.getMessage());
        }
    }
}
