package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.service.LessonService;
import com.example.springapp.model.Lesson;

@RestController
//santhosh
@CrossOrigin(origins = "https://8081-cbbdbceccaaadcdddffaedcbcabfdfafdade.project.examly.io")

//ramesh
//@CrossOrigin(origins = "https://8081-febcaabfefeacfadcdddffaedcbcabfdfafdade.project.examly.io")

//rithick
//@CrossOrigin(origins = "https://8081-ccfbbdadfbadcdddffaedcbcabfdfafdade.project.examly.io")

//oviya
//@CrossOrigin(origins = "https://8081-bfbbbeacbadcdddffaedcbcabfdfafdade.project.examly.io")

//joshika
//@CrossOrigin(origins = "https://8081-fdfedfdaaaacfedbadcdddffaedcbcabfdfafdade.project.examly.io")

//sumanth
//@CrossOrigin(origins = "https://8081-daeacaadbcfaeadcdddffaedcbcabfdfafdade.project.examly.io")

//mrinal
//@CrossOrigin(origins = "https://8081-fbbfbccabebadcdddffaedcbcabfdfafdade.project.examly.io")

//muskan
//@CrossOrigin(origins = "https://8081-ddefcefdabfbdadcdddffaeeaeaadbdbabf.project.examly.io")

//rishik
//@CrossOrigin(origins = "https://8081-caccdedfdbdccefeadcdddffaedcbcabfdfafdade.project.examly.io")

@RequestMapping("/lesson")
public class LessonController {
   
    private final LessonService lessonService;
    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
        
    }

    // To get all the lessons
    @GetMapping
    public ResponseEntity<List<Lesson>> getAllLessons() {
        List<Lesson> lesson = lessonService.findAllLessons();
        return new ResponseEntity<>(lesson, HttpStatus.OK);
    }

    // To add new lesson
    @PostMapping("/add")
    public ResponseEntity<Lesson> addLesson(@RequestBody Lesson lesson) {
        Lesson newLesson = lessonService.addLesson(lesson);
        return new ResponseEntity<>(newLesson, HttpStatus.CREATED);
    }

    // To update the lesson
    @PutMapping("/update")
    public ResponseEntity<Lesson> updateLesson(@RequestBody Lesson lesson) {
        Lesson updatedLesson = lessonService.updateLesson(lesson);
        return new ResponseEntity<>(updatedLesson, HttpStatus.OK);
    }

    // To delete the lesson based on lessonid
    @DeleteMapping("/delete/{lessonId}")
    public ResponseEntity<?> deleteLesson(@PathVariable("lessonId") Long lessonId) {
        lessonService.deleteLesson(lessonId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // To display the lessons based on courseid
    @GetMapping("/{courseId}")
    public ResponseEntity<List<Lesson>> getLessonByCourseId(@PathVariable("courseId") Long courseId) {
        List<Lesson> lesson = lessonService.getLessonByCourseId(courseId);
        return new ResponseEntity<>(lesson, HttpStatus.OK);
    }

    // To display the lessons based on lessonid
    @GetMapping("/getbyid/{lessonId}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable("lessonId") Long lessonId){
        Lesson lesson = lessonService.getLessonById(lessonId);
        return new ResponseEntity<>(lesson, HttpStatus.OK);
    }

}
