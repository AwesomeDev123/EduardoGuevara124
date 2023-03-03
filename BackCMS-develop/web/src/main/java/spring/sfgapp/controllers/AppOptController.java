package spring.sfgapp.controllers;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import spring.sfgapp.entity.AppOpt;
import spring.sfgapp.services.AppOptService;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping({"appopt", "appopts"})
public class AppOptController {
	private final AppOptService appOptService;

	public AppOptController(AppOptService appOptService) {
		this.appOptService = appOptService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping({ "/list", "/lists" })
	public ResponseEntity<List<AppOpt>> AppOptList() {
		List<AppOpt> list = appOptService.lfindAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{appoptId}/edit")
	public ResponseEntity<Object> initUpdateAppOptForm(@Valid AppOpt appopt, BindingResult result,
			@PathVariable Long appoptId) {
		if (result.hasErrors()) {
			List<String> errors = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		} else {
			AppOpt editedAppOpt = appOptService.findById(appoptId);
			return new ResponseEntity<>(editedAppOpt, HttpStatus.OK);
		}
	}

	@GetMapping
	@RequestMapping("/{appoptId}/delete")
	public void deleteById(@PathVariable String appoptId) {
		appOptService.deleteById(Long.valueOf(appoptId));
	}

	@PostMapping("/new")	
	public ResponseEntity<Object> processCreationForm(@Valid @RequestBody AppOpt requestBody, BindingResult result) {
		
		if (result.hasErrors()) {
			List<String> errors = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.OK);
		} else {
			AppOpt savedAppOpt = appOptService.save(requestBody);
			return new ResponseEntity<>(savedAppOpt, HttpStatus.CREATED);
		}
	}

	/*
	 * if (!multipartImg.isEmpty()){ try { saveImage(multipartImg,
	 * httpServletRequest); } catch(IOException e){ return null; } }else{ return
	 * null; }
	 */

}
/*
 * @PostMapping(value = "/new", consumes = { MediaType.APPLICATION_JSON_VALUE,
 * MediaType.MULTIPART_FORM_DATA_VALUE }) public AppOpt
 * ProcessCreationForm(@RequestPart("appOpt") String
 * appOpt, @RequestPart("srcImg") List<MultipartFile> srcImg ) throws
 * IOException { AppOpt appOptJson; appOptJson = appOptService.getJson(appOpt,
 * srcImg); return appOptJson;
 */
/*
 * private String saveImage(MultipartFile multipartFile, HttpServletRequest
 * httpServletRequest) throws IOException { String fileName =
 * multipartFile.getOriginalFilename(); String filePath =
 * httpServletRequest.getServletContext().getRealPath("resources/images");
 * 
 * try{ File imageFile = new File(filePath+fileName);
 * multipartFile.transferTo(imageFile); return fileName; } catch (IOException e)
 * { return null; } }
 */
/*
 * @PostMapping("/new") public ResponseEntity<Object>
 * processCreationForm(@RequestBody AppOpt request, @Valid AppOpt appopt,
 * BindingResult result) { public ResponseEntity<Object>
 * processCreationForm(@RequestBody AppOpt request, @ModelAttribute AppOpt
 * appOpt, BindingResult result, Model model,
 * 
 * @RequestParam("optSrcImg") MultipartFile multiPart, HttpServletRequest
 * httpServletRequest, RedirectAttributes attributes) { if (result.hasErrors())
 * { List<String> errors = result.getAllErrors().stream()
 * .map(DefaultMessageSourceResolvable::getDefaultMessage)
 * .collect(Collectors.toList()); return new ResponseEntity<>(errors,
 * HttpStatus.OK); } else { AppOpt savedAppOpt = appOptService.save(request);
 * return new ResponseEntity<>(savedAppOpt,HttpStatus.CREATED); } }
 */
/*
 * if (!multipartImg.isEmpty()){ try { saveImage(multipartImg,
 * httpServletRequest); } catch(IOException e){ return null; } }else{ return
 * null; }
 */

/*
 * 
 * @PostMapping("/MediaType") public ResponseEntity<Object>
 * processCreationMedia(@RequestBody AppOpt request, @Valid AppOpt appopt,
 * BindingResult result) throws IOException {
 * 
 * if (result.hasErrors()) { List<String> errors =
 * result.getAllErrors().stream()
 * .map(DefaultMessageSourceResolvable::getDefaultMessage)
 * .collect(Collectors.toList()); return new ResponseEntity<>(errors,
 * HttpStatus.OK); } else { AppOpt savedAppOpt = appOptService.save(request);
 */
/*
 * AppOpt savedAppOpt = appOptService.save(request); if (savedAppOpt != null){
 * try { //saveImage(multipartImg, httpServletRequest); } catch(IOException e){
 * return null; } }else{
 *//*
	 * 
	 * return null; }
	 * 
	 * //return new ResponseEntity<>(savedAppOpt,HttpStatus.CREATED);
	 * 
	 * }
	 * 
	 * @PostMapping(value = "/Ivan") public ResponseEntity<Object>
	 * Save(@ModelAttribute AppOpt appopt, BindingResult result, Model model,
	 * 
	 * @RequestParam("optSrcImg") MultipartFile multiPart, HttpServletRequest
	 * request, RedirectAttributes attributes) {
	 * 
	 * if (result.hasErrors()){
	 * 
	 * System.out.println("errors"); return null; }
	 * 
	 * if (!multiPart.isEmpty()) { String imageName =
	 * ImageUtility.guardarImagen(multiPart,request); if (imageName !=null){ // La
	 * imagen si se subio appopt.setOptTitle(imageName); // Asignamos el nombre de
	 * la imagen } }
	 * 
	 * // Primero insertamos el detalle appOptService.save(appopt);
	 * //serviceDetalles.insertar(pelicula.getDetalle()); // Como el Detalle ya
	 * tiene id, ya podemos guardar la pelicula //
	 * servicePeliculas.insertar(pelicula); attributes.addFlashAttribute("msg",
	 * "Los datos de la pelicula fueron guardados!"); //return
	 * "redirect:/peliculas/index"; return new
	 * ResponseEntity<>(appopt,HttpStatus.CREATED); }
	 */
