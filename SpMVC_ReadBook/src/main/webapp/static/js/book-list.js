$(function () {
  $("td.book-title").click(function () {
    let seq = $(this).data("seq");
    alert(seq);
  });
});
