
function Calculator() {
	this.current = "0";
	this.buffer = "0";
	this.operator = null;
	this.wasOperator = false;
	this.wasEquals = false;
	
	Calculator.prototype.compute = function(input) {
		if (this.isDigit(input)) {
			if (this.wasEquals) {
				this.current = "0";
				this.buffer = "0";
				this.operator = null;
				this.wasEquals = false;
			} else if (this.wasOperator) {
				this.wasOperator = false;
				
				this.current = "0";
			}
			
			if (this.current == "0") {
				this.current = input;
			} else {
				this.current = this.current + input;
			}
			
			return this.current;
		} else if (this.isOperator(input)) {
			if (this.operator == "+") {
				this.current = parseInt(this.buffer) + parseInt(this.current);
			} else if (this.operator == "-") {
				this.current = parseInt(this.buffer) - parseInt(this.current);
			} 
			
			this.wasOperator = true;
			this.operator = input;
			this.buffer = this.current;
			this.wasEquals = false;
			
			return this.current;
		} else if (input == "=") {
			if (this.operator == "+") {
				this.current = parseInt(this.buffer) + parseInt(this.current);
			} else if (this.operator == "-") {
				this.current = parseInt(this.buffer) - parseInt(this.current);
			} 
			
			this.wasEquals = true;
			
			return this.current;
		} else {
			return "0";
		}
	};
	
	Calculator.prototype.isDigit = function(input) {
		var digits = "1234567890";
		if (input && input.length == 1 && digits.indexOf(input)!=-1) {
			return true;
		} else {
			return false;
		}
	};
	
	Calculator.prototype.isOperator = function(input) {
		var operators = "-+";
		if (input && input.length == 1 && operators.indexOf(input)!=-1) {
			return true;
		} else {
			return false;
		}
	};
}

var calc = new Calculator();