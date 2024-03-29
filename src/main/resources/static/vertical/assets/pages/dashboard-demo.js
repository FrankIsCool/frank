/*
 Template Name: Opatix - Admin & Dashboard Template
 Author: Myra Studio
 File: Dashboard
*/

$(function () {
    "use strict";
    $("#morris-line-example").length && Morris.Line({
        element: "morris-line-example",
        gridLineColor: "#eef0f2",
        lineColors: ["#f15050", "#6d61ea", "#e9ecef"],
        data: [{y: "2006", a: 80, b: 100, c: 45}, {y: "2007", a: 110, b: 130, c: 52}, {
            y: "2008",
            a: 90,
            b: 110,
            c: 68
        }, {y: "2009", a: 120, b: 140, c: 58}, {y: "2010", a: 110, b: 125, c: 32}, {
            y: "2011",
            a: 170,
            b: 190,
            c: 45
        }, {y: "2012", a: 120, b: 140, c: 58}, {y: "2013", a: 80, b: 100, c: 68}, {
            y: "2014",
            a: 110,
            b: 130,
            c: 78
        }, {y: "2015", a: 90, b: 110, c: 62}, {y: "2016", a: 120, b: 140, c: 55}, {
            y: "2017",
            a: 110,
            b: 125,
            c: 45
        }, {y: "2018", a: 170, b: 190, c: 32}, {y: "2019", a: 120, b: 140, c: 45}, {y: "2020", a: 120, b: 140, c: 58}],
        xkey: "y",
        ykeys: ["a", "b", "c"],
        hideHover: "auto",
        resize: !0,
        labels: ["Product A", "Product B", "Product C"]
    })
});