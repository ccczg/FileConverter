package net.chanrich.fileconverter.controller;

import net.chanrich.fileconverter.common.Result;
import net.chanrich.fileconverter.common.ResultGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Effort
 * @date: 2021-04-21
 * @time: 10:01 上午
 * @description: PDF
 */
@RestController
@RequestMapping("pdf")
public class PdfController {
    @GetMapping("/pdfToImage")
    public Result pdfToImage() {
        return ResultGenerator.genSuccessResult();
    }
}
