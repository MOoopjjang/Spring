package com.mooop.todo.controller

import com.mooop.todo.controller.dto.MemoDto
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Project: kmvc
 * Package :com.mooop.todo.controller
 * Author : mooopjjang
 * Date 2024/07/19
 * DESC :
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/memos/api")
class MemoController {
    val log = LoggerFactory.getLogger(MemoController::class.java)

    companion object {
        var cache: MutableList<MemoDto> = mutableListOf(
            MemoDto("A0001", "hi1", "잘지내고 있나요?"), MemoDto("A0002", "문제가 있네", "test2"), MemoDto("A0003", "cccc", "dddd")
        )
    }

    @GetMapping("/")
    fun memoList(): ResponseEntity<List<MemoDto>> = ResponseEntity.ok().body(cache)

    @GetMapping("/{id}")
    fun memo(@PathVariable id:String):ResponseEntity<MemoDto>{
        for( m in cache){
            if(m.id == id){
                return ResponseEntity.ok().body(m);
            }
        }

        return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/")
    fun regist(@RequestBody memo: MemoDto): ResponseEntity<MemoDto> {
        memo.id = "A".plus(cache.size.toString())
        log.info("### regist > memo = {}" , memo.toString())
        return cache.add(memo).let {
            ResponseEntity.ok().body(memo)
        }
    }


    @DeleteMapping("/{id}")
    fun unregist(@PathVariable id: String): ResponseEntity<String> {
        log.info("### unregist > id = {}" , id)
        for(m in cache){
            if( m.id == id){
                log.info(">>> unregist delete = {}",m.toString())
                cache.remove(m)
                break;
            }
        }
        return ResponseEntity.ok().body("SUCCESS")
    }


    @PutMapping("/")
    fun edit(@RequestBody memo: MemoDto): ResponseEntity<String> {
        log.info("### edit > memo = {}" , memo.toString())
        cache.forEach{
            m->
            if (m.id === memo.id) {
                m.content = memo.content
            }
        }
        return ResponseEntity.ok().body("SUCCESS")
    }


}