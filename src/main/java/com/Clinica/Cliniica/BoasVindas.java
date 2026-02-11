package com.Clinica.Cliniica;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@RestController
public class BoasVindas {

        @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
        public String welcome() {
            String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            return """
                    <!DOCTYPE html>
                    <html lang="pt-BR">
                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>API Clínica - Online</title>
                        <style>"
                            body {
                                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                                background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                                color: white;
                                margin: 0;
                                padding: 0;
                                display: flex;
                                justify-content: center;
                                align-items: center;
                                min-height: 100vh;
                                text-align: center;
                            }
                            .container {
                                background: rgba(255, 255, 255, 0.15);
                                backdrop-filter: blur(10px);
                                border-radius: 20px;
                                padding: 40px;
                                max-width: 600px;
                                box-shadow: 0 8px 32px rgba(0,0,0,0.37);
                                border: 1px solid rgba(255,255,255,0.18);
                            }
                            h1 { margin: 0; font-size: 3em; text-shadow: 2px 2px 10px rgba(0,0,0,0.5); }
                            p { font-size: 1.2em; margin: 20px 0; }
                            .btn {
                                display: inline-block;
                                background: white;
                                color: #4a00e0;
                                padding: 14px 32px;
                                margin: 10px;
                                border-radius: 50px;
                                text-decoration: none;
                                font-weight: bold;
                                font-size: 1.1em;
                                transition: all 0.3s;
                                box-shadow: 0 4px 15px rgba(0,0,0,0.2);
                            }
                            .btn:hover {
                                transform: translateY(-3px);
                                box-shadow: 0 10px 25px rgba(0,0,0,0.3);
                            }
                            footer { margin-top: 40px; font-size: 0.9em; opacity: 0.8; }
                        </style>
                    </head>
                    <body>
                        <div class="container">
                            <h1>API Clínica</h1>
                            <p>Backend de gerenciamento de clínica médica</p>
                            <p>Status: <strong>Online e funcional</strong> 🚀</p>
                            <p>Data/hora do servidor: %s</p>
                    
                            <a href="/swagger-ui.html" class="btn">Testar a API (Swagger UI)</a>
                            <a href="/v3/api-docs" class="btn">Ver OpenAPI JSON</a>
                    
                            <footer>
                                Desenvolvido por Leonardo • Deploy no Render • Spring Boot + PostgreSQL
                            </footer>
                        </div>
                    </body>
                    </html>
                    """.formatted(now);
        }
}
