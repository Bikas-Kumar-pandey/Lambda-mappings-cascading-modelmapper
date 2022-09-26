 {
        "name": "KeebController",
            "id": "KeebController",
            "operations": [
        {
            "name": "create",
                "auditable": "false",
                "url": "/keeb",
                "httpMethod": "POST",
                "produces": "JSON",
                "consumes": "JSON",
                "secure": false,
                "input": "com.meratransport.indent.dto.IndentServiceRequest",
                "output": "",
                "params": [
            {
                "name": "indentEntityRequest",
                    "type": "BODY",
                    "description": "Creates an indent with the given trip plan and indent details."
            }
			]
        },
}
