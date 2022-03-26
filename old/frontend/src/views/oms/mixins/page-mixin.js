import { mapGetters } from 'vuex'
export default {
  props: {
  },
  data() {
    return {
      pageConfig: {
        title: '',
        loadingText: '',
        bodyHeight: 800,
        // pageHeight: 600,
        bodyMinusTableHeight: 180
      },
      tableOptions: {
        tableHeight: 400
      }
    }
  },
  beforeMount() {
    window.addEventListener('resize', this.$_resizeHandler)
  },
  beforeDestroy() {
    window.removeEventListener('resize', this.$_resizeHandler)
  },
  created() {
  },
  mounted() {
  },
  methods: {
    $_resizeHandler() {
      console.log('$_resizeHandler in Pagemixin')
      this.pageConfig.bodyHeight = document.body.getBoundingClientRect().height
    },
    getCurrentView() {
      let currentView
      const currentFullPath = this.$route.fullPath
      this.$store.state.tagsView.visitedViews.some((view) => {
        if (view.fullPath === currentFullPath) {
          currentView = view
          return true
        }
      })
      return currentView
    },
    setCurrentViewTitle(title) {
      const currentView = this.getCurrentView()
      if (currentView) currentView.title = title || this.pageConfig.title
    },
    closeCurrentView(delay) {
      const currentView = this.getCurrentView()
      if (currentView) {
        if (delay) {
          this.pageConfig.isLoading = true
          this.pageConfig.loadingText = this.pageConfig.loadingText + `将在${delay}秒后关闭本页签。`
          setTimeout(() => {
            this.$root.eventHub.$emit('CLOSE-VIEW', currentView)
          }, delay * 1000)
        } else {
          this.$root.eventHub.$emit('CLOSE-VIEW', currentView)
        }
      }
    }
  },
  computed: {
    ...mapGetters([
      'sidebar',
      'avatar',
      'device',
      'userId',
      'userName',
      'fullName'
    ])
  }
  // watch: {
  //   'tableOptions.height': function (val) {
  //     console.log('watch:options.tableOptions', val)
  //   }
  // }
}
