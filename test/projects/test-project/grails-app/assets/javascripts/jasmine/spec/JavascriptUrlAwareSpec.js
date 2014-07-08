describe("When served from a war file, Javascript should serve cached urls for", function() {

  it("simple asset paths like: assets/isUrlAware.html", function() {
    var url = "assets/isUrlAware.html";
    expect(url).toEqual("assets/isUrlAware-a74292018cf33cac18cccd6af55911e8.html");
  });

  it("as well as deep paths like: assets/jasmine/spec/deepPathUrlAware.html", function() {
    var url = "assets/jasmine/spec/deepPathUrlAware.html";
    expect(url).toEqual("assets/jasmine/spec/deepPathUrlAware-a74292018cf33cac18cccd6af55911e8.html");
  });

});
