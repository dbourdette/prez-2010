
function Shape() {
	this.x = 0;
	this.y = 0;
}

Shape.prototype.setPosition = function(x, y) {
	this.x = x;
	this.y = y;
};

Shape.prototype.paint = function(context) {}

Circle.prototype = new Shape(); 
Circle.prototype.constructor = Circle;

function Circle(radius) {
	this.radius = radius;
}

Circle.prototype.area = function() {
	return ( Math.PI * this.radius * this.radius );
};

Circle.prototype.paint = function(context) {
	context.beginPath();
	context.arc(this.x, this.y, this.radius, 0, Math.PI*2, true);
	context.closePath();
	context.fill();
};

Rectangle.prototype = new Shape();
Rectangle.prototype.constructor = Rectangle;

function Rectangle(width, height) {
	this.width = width;
	this.height = height;
}

Rectangle.prototype.area = function() {
	return ( this.width * this.height );
};

Rectangle.prototype.paint = function(context) {
	context.fillRect(this.x, this.y, this.width, this.height);
};

var deltaY = 10;
var deltaX = 10;

function updateState(shape) {
	if (shape.y >= 300 || shape.y <= 0) {
		deltaY = -deltaY;
	}
	
	if (shape.x >= 840 || shape.x <= 0) {
		deltaX = -deltaX;
	}
	
	shape.setPosition(shape.x + deltaX, shape.y + deltaY);
}