/************************
* DEPENDENCES
*************************/
var gulp = require('gulp'),
	concat = require('gulp-concat'),
	uglify = require('gulp-uglify'),
	jade = require('gulp-jade'),
	fs = require('fs'),
	path = require('path'),
	livereload = require('gulp-livereload');

/************************
* CONSTANTS
*************************/
//JADE
var routeTemplates = path.join(__dirname)+"/templates/**/**.jade";
var routeIndex = path.join(__dirname)+"/templates/index.jade";
var routeOthers = path.join(__dirname)+"/templates/partials/**/**.jade";
var minified = false;

gulp.task('templates', function(){
	console.log("Running templates");
	gulp.src(routeIndex)
		.pipe(jade({
			pretty : !minified,
			basedir : routeIndex
		}))
		.pipe(gulp.dest( path.join(__dirname) ))
		.pipe(livereload());

	gulp.src(routeOthers)
		.pipe(jade({
			pretty : !minified,
			basedir : routeOthers
		}))
		.pipe(gulp.dest( path.join(__dirname) ))
		.pipe(livereload());
});

gulp.task('watch', function() {
    livereload.listen({
    	start : true
    });
    gulp.watch([routeTemplates],['templates']).on('change', function(event) {
        livereload.changed();
        console.log('File', event.path, 'was', event.type);
        console.log('LiveReload is triggered');
    });
});

gulp.task('default', ['templates','watch']);

