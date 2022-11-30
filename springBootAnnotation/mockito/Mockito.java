package springBootAnnotation.mockito;
// E.g
@Autowired
MockMvc mockMvc;

@Test
void testFindAllBooks() throws Exception{
  Book book = new Book(1l, "Tommy's Books", LocalDate.of(2022, Month.JUNE, 22), new Author() );

  when(bookService.findAllBooks()).thenReturn(List.of(book));

  MvcResult result =  mockMvc.perform(get("/api/v1/books/bookstore/books"))
    .andDo(print())
    .andExpect(status().isOk())
    .andReturn();
//.andExpect(jsonPath("$[0].bookName").value("Tommy's Books"))